/**
 * @return {Function}
 */
var createHelloWorld = function() {
    
    return function(...args) {
        return "hello world"
    }
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */