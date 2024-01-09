package kim.v1.controller;

import kim.v1.data.Item;
import kim.v1.data.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basic/items")
public class ItemController {
    private final ItemRepository repository;
    @GetMapping
    public String items(Model model){
        List<Item> items = repository.findAll();
        model.addAttribute("items",items);
        return "basic/items";
    }
    @GetMapping("/{itemId}")
    public String item(@PathVariable("itemId") Long id,Model model){
        Item item = repository.findById(id);
        model.addAttribute("item",item);
        return "basic/item";
    }
    @GetMapping("/add")
    public String add(){
        return "basic/formAdd";
    }
    @PostMapping("/add")
    public String add2(@ModelAttribute Item item){
        repository.save(item);
        return "redirect:/basic/items";
    }

    @GetMapping("/delete/{itemId}")
    public String del(@PathVariable("itemId")Long id){
        repository.delete(id);
        return "redirect:/basic/items";
    }
    @GetMapping("/delete/all")
    public String del(){
        repository.clear();
        return "redirect:/basic/items";
    }
    @GetMapping("/{itemId}/edit")
    public String edit(@PathVariable("itemId") Long id,Model model){
        Item item = repository.findById(id);
        model.addAttribute("item",item);
        return "basic/formEdit";
    }
    @PostMapping("/{itemId}/edit")
    public String edit2(@PathVariable("itemId") Long id,@ModelAttribute Item upItem){
        Item item = repository.update(id,upItem);
        return "redirect:/basic/items/"+id;
    }
}
