package kim.v1.data;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Item {
    private long id;
    private String itemName;
    private Long price;
    private Long quantity;
    public Item(String itemName,Long price,Long quantity){
        this.itemName=itemName;
        this.price=price;
        this.quantity=quantity;
    }
    public Item(){

    }
    //@ModelAttribute 사용시 기본 생성자 있어야된다.
}
