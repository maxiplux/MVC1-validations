package cs544.exercise19;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class BookController {

    @Resource
    private IBookDao bookDao;

    @RequestMapping("/")
    public String redirectRoot() {
        return "redirect:/books";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("books", bookDao.getAll());
        return "/bookStore/bookList";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("book", new Book());
        return "/bookStore/bookDetail";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)

    public String add(@Valid Book book, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors())
        {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.contact", result);
            attr.addFlashAttribute("book", book);
            return "/bookStore/bookDetail";
        }
        bookDao.add(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/books/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("book", bookDao.get(id));
        return "/bookStore/bookDetail";
    }

    @RequestMapping(value = "/books/edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable int id, Book book) {
        bookDao.update(id, book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/books/delete", method = RequestMethod.POST)
    public String delete(int bookId) {
        bookDao.delete(bookId);
        return "redirect:/books";
    }
}
