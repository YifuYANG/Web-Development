package app;
import app.Entity.Person;
import app.Entity.Phone;
import app.Repository.PersonRepository;
import app.Repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController
{
    @Autowired
    private PersonRepository personrepository;
    @Autowired
    private PhoneRepository phonerepository;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model)
    {
        model.addAttribute("people", personrepository.findAll());
        return "index.html";
    }

    @PostMapping("/addPerson")
    public @ResponseBody Person addPerson(@RequestBody Person person)
    {
        personrepository.save(person);
        return person;
    }

    @GetMapping("/removePerson")
    public @ResponseBody Integer removePerson(@RequestParam Integer id)
    {
        /*Person person=personrepository.getOne(id);
        if(person.getNumber().size()!=0)
        {
           person.getNumber().clear();
        }*/
        personrepository.deleteById(id);
        return id;
    }

    @GetMapping("/phones/{id}")
    public String viewPhone(@PathVariable int id,Model model)
    {
        model.addAttribute("person",personrepository.getOne(id));
        return "phone.html";
    }

    @PostMapping("/phones/add")
    public @ResponseBody Phone addNumber(@RequestBody Phone phone,@RequestParam Integer id)
    {
        //System.out.println(phone.getId());
        //System.out.println(phone.getType());
        //System.out.println(phone.getNumber());
        Person person=personrepository.getOne(id);
        person.getNumber().add(phone);
        phone.setUser(person);
        phonerepository.save(phone);
        return phone;
    }

    @GetMapping("/removePhone")
    public @ResponseBody Integer removePhone(@RequestParam Integer id)
    {
        phonerepository.deleteById(id);
        return id;
    }
}
