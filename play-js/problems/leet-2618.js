/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function (obj, classFunction) {
    if (obj == null || typeof classFunction != 'function' || typeof obj == 'undefined') {
        return false
    }
    if (obj instanceof classFunction) {
        return true
    }
    const objProto = Object.getPrototypeOf(obj)
    const classProto = classFunction.prototype
    return isProto(objProto, classProto)
};

function isProto(objProto, classProto) {
    if (!objProto) {
        return false
    }
    if (objProto == classProto) {
        return true
    }
    return isProto(Object.getPrototypeOf(objProto), classProto)
}

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */

export default checkIfInstanceOf;
