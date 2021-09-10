var slides = document.querySelector('.slides'),
    slide = document.querySelectorAll('.slides li'),
    currentIdx = 0,
    slideCount = slide.length,
    slideHeight = 100,
    prevBtn = document.querySelector('.prev'),
    nextBtn = document.querySelector('.next');

makeClone();
nextBtn.addEventListener('click',function(){
    moveSlide(currentIdx+1);
})
prevBtn.addEventListener('click',function(){
    moveSlide(currentIdx-1);
})

function makeClone(){
    for(var i=0; i<slideCount; i++){
        //a.cloneNode(), a.cloneNode(true)
        var cloneSlide = slide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        slides.appendChild(cloneSlide);
    }
    for(var i =slideCount-1;i>=0;i--){
        var cloneSlide = slide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        slides.prepend(cloneSlide);
    }
    updateHeight();
    setInitialPos();
    setTimeout(function(){
        slides.classList.add('animated');
    },100);
}

function updateHeight(){
    var currentSlides = document.querySelectorAll('.slides li');
    var newSlideCount = currentSlides.length;
    var newHeight = slideHeight*newSlideCount+'px';
    slides.style.height = newHeight;
}
function setInitialPos(){
    var initialTranslateValue = -slideHeight*slideCount;
    slides.style.transform = 'translateY('+initialTranslateValue+'px)';
}
function moveSlide(num){
    slides.style.top = -num*slideHeight+'px';
    currentIdx = num;
    console.log(currentIdx, slideCount);
    if(currentIdx == slideCount || currentIdx == -slideCount){
        setTimeout(function(){
            slides.classList.remove('animated');
            slides.style.top = '0px';
            currentIdx = 0;
        }, 500);
        setTimeout(function(){
            slides.classList.add('animated');
        },600);
    }
}

var timer = undefined;

function autoSlide(){
    if (timer === undefined){
        timer = setInterval(function(){
            moveSlide(currentIdx+1);
        }, 3000);
    }
}
autoSlide();

slides.addEventListener('mouseenter', function(){
    stopSlide();
});
slides.addEventListener('mouseleave', function(){
    autoSlide();
});
function stopSlide(){
    clearInterval(timer);
    timer = undefined;
}