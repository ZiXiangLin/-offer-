function Counter() {
    var counter = 0;
    setTimeout( function() {
        counter += 1;
        var innerCounter = 0;
        console.log("counter = " + counter);

        setTimeout( function() {
            counter += 1;
            innerCounter += 1;
            console.log("counter = " + counter);
            console.log("innerCounter = " + innerCounter);
        }, 500);
    }, 1000);
};
Counter();
// output:
// counter = 1
// counter = 2
// innerCounter = 1
