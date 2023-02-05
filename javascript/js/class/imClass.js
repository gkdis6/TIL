
class Widget{
    constructor(type) {
        this.type = type;
    }
    
    getItem() {
        console.log('item');
    }

    getSettingItem() {
        console.log('settingItem');
    }
}

class imWidget extends Widget {
    constructor(type, name){
        super(type);
        this.name = name;
    }

    getItem = ({WIDE, WIDGET}) => {
        return `<li class="${WIDE} widget-${this.type}" id="${WIDGET}" srno="${this.type}">
                            <h3>
                               <span class="title">${this.name}</span>
                               <div class="widget-button-wrap">
                                   <button class="button-del-widget">
                                       <i class="icons-delete-3"></i>
                                   </button>
                               </div>
                            </h3>
                            <ul id="alarmWidget" class="scroll-mask thin" scroll-direction="0">
                            </ul>
                        </li>`
    }

    getSettingItem = (rec) => {
        return `<li class="item"><input type="checkbox" name="${rec}" id="dashboard-widget-img-11"><label for="dashboard-widget-img-11"><span><span>위젯추가</span></span></label></li>`
    }
}

const alarmWidget = new imWidget(7, 'alarm');


console.log(alarmWidget.getItem({WIDE : 'wide', WIDGET : 1}));
console.log(alarmWidget.getSettingItem('alarm'));




