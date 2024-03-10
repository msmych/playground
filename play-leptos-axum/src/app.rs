use std::collections::HashMap;

use crate::error_template::{AppError, ErrorTemplate};
use leptos::{
    component, create_signal, event_target_value, view, Errors, IntoView, ReadSignal, Show,
    SignalGet,
};
use leptos_meta::*;
use leptos_router::*;
use rand::Rng;

/// The main entry point for your application.
#[component]
pub fn App() -> impl IntoView {
    // Provides context that manages stylesheets, titles, meta tags, etc.
    provide_meta_context();

    view! {
        // injects a stylesheet into the document <head>
        // id=leptos means cargo-leptos will hot-reload this stylesheet
        <Stylesheet id="leptos" href="/pkg/play-leptos-axum.css"/>

        // sets the document title
        <Title text="Welcome to Leptos"/>

        // content for this welcome page
        <Router fallback=|| {
            let mut outside_errors = Errors::default();
            outside_errors.insert_with_default_key(AppError::NotFound);
            view! {
                <ErrorTemplate outside_errors/>
            }
            .into_view()
        }>
            <main>
                <Routes>
                    <Route path="" view=HomePage/>
                </Routes>
            </main>
        </Router>
    }
}

/// Renders the home page of your application.
#[component]
fn HomePage() -> impl IntoView {
    let mut words: HashMap<String, String> = HashMap::new();
    words.insert("도시".into(), "city".into());
    words.insert("이름".into(), "name".into());
    words.insert("저".into(), "I".into());
    words.insert("나".into(), "I".into());
    words.insert("남자".into(), "man".into());
    words.insert("여자".into(), "woman".into());
    words.insert("이".into(), "this".into());
    words.insert("그".into(), "that".into());
    words.insert("저".into(), "that".into());
    words.insert("것".into(), "thing".into());

    let pick_word = move || {
        let mut rng = rand::thread_rng();
        let index = rng.gen_range(0..words.len());
        let key = words.keys().nth(index).unwrap();
        (key.to_owned(), words.get(key).unwrap().to_owned())
    };

    let (word, set_word) = create_signal(pick_word());

    view! {
        <Card word=word />
        <div>
            <button on:click=move |_| set_word(pick_word())>"Next"</button>
        </div>
    }
}

#[component]
fn Card(word: ReadSignal<(String, String)>) -> impl IntoView {
    let (value, set_value) = create_signal(String::new());
    let on_input = move |e| set_value(event_target_value(&e));
    let (submitted, set_submitted) = create_signal(false);
    let on_click = move |_| set_submitted(!submitted.get());
    view! {
        <h1>{move || word.get().0 }</h1>
        <input type="text" prop:value=value on:input=on_input placeholder="English" />
        <button on:click=on_click>"Answer"</button>
        <Show when=submitted>
            <h2>{move || word.get().1}</h2>
        </Show>
    }
}
