// The days of the week are: "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
function getDayName(dateString) {
    let dayName;
    // Write your code here
    let myDate  = new Date(dateString);
    var days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    dayName = days[myDate.getDay()];
    return dayName;
}