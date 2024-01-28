Array.from(document.getElementsByClassName('addresses-page__region'))
  .map(el => {
    return {
      region: el.children[0].children[0].innerText,
      signatures: el.children[1]?.children[0]?.children[0]?.innerText?.split(':')[1]
    }
  })
  .filter(({ signatures }) => signatures)
  .map(({ region, signatures }) => {
    console.log(`${region}: ${signatures}`)
    return { region, signatures }
  })
  .map(({ signatures }) => Math.min(parseInt(signatures.split('/')[0].trim()), 2500))
  .reduce((a, b) => a + b)
