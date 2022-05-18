package tacos.web.api;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tacos.Taco;
import tacos.data.TacoRepository;
    @RestController
    @RequestMapping(path = "/tacos", produces = "application/json")
    @CrossOrigin(origins = "*")
    public class TacoController {
        private TacoRepository tacoRepo;
        EntityLinks entityLinks;
        public TacoController(TacoRepository tacoRepo) {
            this.tacoRepo = tacoRepo;
        }
        @GetMapping
        public Iterable<Taco> getAllTacos() {
            return tacoRepo.findAll();
        }
        @GetMapping("/{id}")
        public Taco tacoById(@PathVariable("id") Long id) {
            Optional<Taco> optTaco = tacoRepo.findById(id);
            if (optTaco.isPresent()) {
                return optTaco.get();
            }
            return null;
        }
    }