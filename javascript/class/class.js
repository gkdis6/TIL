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

const hiWidget = new Widget('hi');

hiWidget.getItem();
hiWidget.getSettingItem();

//글, 업무, 사용자 정보


export {Widget}