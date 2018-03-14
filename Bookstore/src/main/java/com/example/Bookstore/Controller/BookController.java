package com.example.Bookstore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.Books.Book;
import com.example.Bookstore.Books.BookRepository;




@Controller
public class BookController {	
	
	@Autowired
	private BookRepository repository;
	
	// Show all students
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
	@RequestMapping("/index")
	public String home() {
		// pääsivu kirjakaupalle
		
		//Luodaan sitten kirja.
		Book jokuKirja = new Book();
		
		return "index";
	}
	
	//List all
	@RequestMapping(value="/booklist")
    public String bookList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
	
	// RESTful service to get all books
    @RequestMapping(value="/api", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }   
  
    //Add new book
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    }
    
 // RESTful service to get book by id
    @RequestMapping(value="/api/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findOne(bookId);
    } 
    
    // Save new book
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }    

    // Delete book
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.delete(bookId);
        return "redirect:../booklist";
    }     
}