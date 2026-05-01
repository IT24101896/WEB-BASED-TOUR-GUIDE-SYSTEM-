// Test script to verify safety risk optimization
// Since this is an ES6 module, we'll create a simple test in the browser console instead

// Test destinations with different safety risk values
const testDestinations = [
    {
        id: 7,
        name: "Unawatuna Beach",
        lat: 6.008096,
        lng: 80.245218,
        safetyRisk: 3.0
    },
    {
        id: 8,
        name: "Mirissa Beach", 
        lat: 5.9476,
        lng: 80.4627,
        safetyRisk: 4.0
    },
    {
        id: 9,
        name: "Arugam Bay",
        lat: 6.8422,
        lng: 81.8289,
        safetyRisk: 5.0
    }
];

console.log('Testing Safety Risk Optimization');
console.log('================================');

const optimizer = new GeneticRouteOptimizer({
    populationSize: 50,
    generations: 100,
    mutationRate: 0.02,
    eliteSize: 10
});

console.log('\nTest Destinations:');
testDestinations.forEach(dest => {
    console.log(`- ${dest.name}: Safety Risk = ${dest.safetyRisk}`);
});

console.log('\nRunning optimization...');
const result = optimizer.optimizeRoute(testDestinations, (progress) => {
    if (progress.generation % 20 === 0) {
        console.log(`Generation ${progress.generation}: Best Distance = ${progress.currentBestDistance.toFixed(2)} km, Safety Risk = ${progress.currentBestSafety.toFixed(1)}`);
    }
});

console.log('\nOptimization Results:');
console.log(`- Total Distance: ${result.distance.toFixed(2)} km`);
console.log(`- Total Safety Risk: ${result.safetyRisk.toFixed(1)}`);
console.log(`- Fitness Score: ${result.fitness.toFixed(2)}`);

console.log('\nOptimized Route:');
result.route.forEach((index, order) => {
    const dest = testDestinations[index];
    console.log(`${order + 1}. ${dest.name} (Safety Risk: ${dest.safetyRisk})`);
});

console.log('\nSafety Risk Optimization Test Complete!');
