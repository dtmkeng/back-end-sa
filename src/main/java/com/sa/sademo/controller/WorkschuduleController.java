package sut.sa.g16.cotroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.sa.g16.model.DataWorkschudule;
import sut.sa.g16.entity.*;
import sut.sa.g16.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
public class WorkschuduleController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryWorkRepository categoryWorkRepository;
    @Autowired
    private PhotographerRepository photographerRepository;
    @Autowired
    private TimetypeRepository timetypeRepository;
    @Autowired
    private WorkschuduleRepository workschuduleRepository;
    @Autowired
    private AdminRepository adminRepository;

    public WorkschuduleController(CategoryRepository categoryRepository, CategoryWorkRepository categoryWorkRepository, PhotographerRepository photographerRepository,
                                  TimetypeRepository timetypeRepository, WorkschuduleRepository workschuduleRepository, AdminRepository adminRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryWorkRepository = categoryWorkRepository;
        this.photographerRepository = photographerRepository;
        this.timetypeRepository = timetypeRepository;
        this.workschuduleRepository = workschuduleRepository;
        this.adminRepository = adminRepository;
    }
    @GetMapping(path = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Category> category() {
        return categoryRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/category-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Category categoryFind(@PathVariable("id") Long id) {
        return categoryRepository.findByCategoryid(id);
    }

    @GetMapping(path = "/categoryWork", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CategoryWork> categoryWork() {
        return categoryWorkRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/categoryWork-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CategoryWork categoryWorkFind(@PathVariable("id") Long id) {
        return categoryWorkRepository.findByCatworkid(id);
    }

    @GetMapping(path = "/photographer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Photographer> photographer() {
        return photographerRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/photographrer-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Photographer findPhotographer(@PathVariable("id") Long id) {
        return photographerRepository.findByPhotograpId(id);
    }

    // @GetMapping(path = "/timetype", produces = MediaType.APPLICATION_JSON_VALUE)
    // public Collection<Timetype> timetype() {
    //     return timetypeRepository.findAll().stream().collect(Collectors.toList());
    // }
    @GetMapping("/timetype-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Timetype findTimetype(@PathVariable("id") Long id) {
        return timetypeRepository.findByTimetypeid(id);
    }

    @GetMapping(path = "/workschudule", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Workschudule> workschudule() {
        return workschuduleRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/workschudule-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Workschudule findWorkschudule(@PathVariable("id") Long id) {
        return workschuduleRepository.findByWorkschuduleid(id);
    }
    @PostMapping("/dataWorkschudule")
    public CategoryWork bodyCategoryWork(@RequestBody DataWorkschudule dataWorkschudule){
       // private  String nameid;
        // private  String categoryid;
        // private  String location;
       //  private  Date date;
        //private  String timetypeid;

         Admin admin = adminRepository.findByAdminid(dataWorkschudule.getAdminid());
         Category category = categoryRepository.findByCategoryid(dataWorkschudule.getCategoryid());
         Photographer photographer = photographerRepository.findByPhotograpId(dataWorkschudule.getNameid());
         Timetype timetype = timetypeRepository.findByTimetypeid(dataWorkschudule.getTimetypeid());
         Workschudule w = this.workschuduleRepository.save(new Workschudule(dataWorkschudule.getDate(),dataWorkschudule.getLocation(),photographer,timetype,admin));
         CategoryWork c =  this.categoryWorkRepository.save(new CategoryWork(w,category));
        return c;
    }

}