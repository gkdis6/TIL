const toggleBtn = document.querySelector('.navbar_toggleBtn');
const menu = document.querySelector('.navbar_menu');
const icons = document.querySelector('.navbar_icons');

toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
    icons.classList.toggle('active');
});

var Name = $('.Name');
Name.animate({opacity:"0"}, 1000);


let allName =['박상용', 'Park SangYong', '朴相勇'];
var i = 0;
function setInnerText() {
    const element = document.getElementById('Name');
    element.innerText = allName[i];
    if(i == 2){
        i = 0;
    }
    i++;
} 

let timer = setInterval(setInnerText, 5000)