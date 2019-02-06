const ages = [23, 25, 23, 12, 19, 20];
let ageSum = 0;

/* Standard For Loop */
for ( let i = 0; i < ages.length; i++ ) {
	ageSum += ages[i];
}

console.log(ageSum);

/* Using Reduce */
const ageSumReduce = ages.reduce( ( total, age ) => {
	return total + age;
}, 0 );

console.log(ageSumReduce); 