/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
     let l= init;
    return{
        increment: function(expected) {
            l=l+1;
            return l;
        },
        decrement: function(expected) {
            l= l-1;
            return l;
        },
        reset: function(expected) {
            l= init
            return l;
        }
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */