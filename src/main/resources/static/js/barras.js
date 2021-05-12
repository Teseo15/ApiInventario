var ch = document.getElementById("chart").getContext('2d');
const config = new Chart(ch,{
	type: 'bar',
	data: {
	labels: ['Week1','Week2','Week3','Week4','Week5','Week6','Week7','Week8','Week9'],
	datasets: [{
    label: 'This Week Sales',
    data: [65, 59, 80, 81, 56, 55, 40, 50, 30],
    backgroundColor: [
      '#d27f6f','#b4e4e8','#d27f6f','#b4e4e8','#d27f6f','#b4e4e8','#d27f6f','#b4e4e8','#d27f6f',],
    borderColor: ['#d27f6f','#b4e4e8','#d27f6f','#b4e4e8','#d27f6f','#b4e4e8','#d27f6f','#b4e4e8','#d27f6f',
    ],
    borderWidth: 1
  }]
},
options: {
                responsive: true
            }
});

var grafica = document.getElementById("grafica");
var myPieChart = new Chart(grafica,{
	type:'doughnut',
	data: {
		labels:['Product1','Product2','Product3','Product4','Product5','Product6',],
		datasets:[{
			label:"Top Selling Products (2021)",
			data: [250,300,150,220,410,315,],
			backgroundColor:["#353535", "#3c6e71", "#d9d9d9", "#a8dadc", "#caf0f8", "#669bbc"]
		}]
		
	},
	options: {
                responsive: true
            }
})



			
			
			
			