var ctx = document.getElementById("myChart").getContext('2d');
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ["Jan", "Feb", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
        datasets: [{
            data: [20, 56, 19, 44, 56, 10, 15, 23, 20, 14, 21, 40],
            backgroundColor: '#E6B0AA',
            borderColor: '#C0392B',
            fill: true,
            pointBackgroundColor: '#C0392B',
            borderWidth: 1
        }]
    },
    options: {
        legend:{
            display: false
        },
        title: {
            display: true,
            text: 'Number of sessions per month'
        },
        animation: {
            duration: 1500
        },
        hover: {
            animationDuration: 1500, // duration of animations when hovering an item
        },
        responsiveAnimationDuration: 1000 // animation duration after a resize
    }
});