package kim.v1.data;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static Map<Long,Item> map = new HashMap<>();
    private static int count=0;
    public Item save(Item item){
        item.setId(++count);
        map.put(item.getId(),item);
        return item;
    }
    public Item findById(Long id){
        return map.get(id);
    }
    public Item update(long id,Item updateItem){
        Item item = map.get(id);
        item.setItemName(updateItem.getItemName());
        item.setPrice(updateItem.getPrice());
        item.setQuantity(updateItem.getQuantity());
        return item;
    }

    public List<Item> findAll(){
        return new ArrayList<>(map.values());
    }

    public void clear(){
        map.clear();
        count=0;
    }
    public void delete(Long id){
        map.remove(id);
    }

    @PostConstruct
    public void init(){
        save(new Item("item1",10000L,10L));
        save(new Item("item2",20000L,20L));
    }
}
