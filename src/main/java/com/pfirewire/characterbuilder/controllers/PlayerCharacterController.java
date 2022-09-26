package com.pfirewire.characterbuilder.controllers;


import com.pfirewire.characterbuilder.models.*;
import com.pfirewire.characterbuilder.repositories.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PlayerCharacterController {

    // Repositories and Services
    private final UserRepository userDao;
    private final PlayerCharacterRepository playerCharacterDao;
    private final RaceRepository raceDao;
    private final CharacterClassRepository characterClassDao;

    // Constructor
    public PlayerCharacterController(
            UserRepository userDao,
            PlayerCharacterRepository playerCharacterDao,
            RaceRepository raceDao,
            CharacterClassRepository characterClassDao)
    {
        this.userDao = userDao;
        this.playerCharacterDao = playerCharacterDao;
        this.raceDao = raceDao;
        this.characterClassDao = characterClassDao;
    }

    // Displays Create Character Form
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("character", new PlayerCharacter());
        return "sheets/create";
    }

    @PostMapping("/create")
    public String createPlayerCharacter(
            @ModelAttribute @Valid PlayerCharacter playerCharacter,
            @RequestParam(name = "allRaces") String race,
            @RequestParam(name = "allClasses") String characterClass,
            Errors validation,
            Model model)
    {
        if(validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("playerCharacter", playerCharacter);
            return "sheets/create";
        }

        playerCharacter.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        playerCharacter.setRace(raceDao.findByType(race));
        playerCharacter.setCharacterClass(characterClassDao.findByName(characterClass));
        playerCharacterDao.save(playerCharacter);
        return "redirect:/characters";
    }

    @GetMapping("/characters")
    public String showCharacters(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "sheets/characters";
    }





//    // Constructor
//    public PostController(
//            PostRepository postDao,
//            UserRepository userDao,
//            EmailService emailService,
//            FileUploadService fileUploadService)
//    {
//        this.postDao = postDao;
//        this.userDao = userDao;
//        this.emailService = emailService;
//        this.fileUploadService = fileUploadService;
//    }
//    // Displays full list of all posts
//    @GetMapping("/posts")
//    public String postsIndex(Model model) {
//        // Sets a post list and passes it to the template
//        List<Post> posts = postDao.findAll();
//        model.addAttribute("posts", posts);
//        return "posts/index";
//    }
//    // Displays individual post
//    @GetMapping("/posts/{id}")
//    public String individualPost(@PathVariable long id, Model model) {
//        // Checks if post id exists, if not redirects to post index
//        if(postDao.findById(id) == null) {
//            return "redirect:/posts";
//        }
//        // Sets individual post by id parameter, passes it to template
//        Post post = postDao.getById(id);
//        model.addAttribute("post", post);
//        return "posts/show";
//    }
//    // Displays form to create a post
//    @GetMapping("/posts/create")
//    public String showCreatePostForm(Model model) {
//        // Passing empty post to form
//        model.addAttribute("post", new Post());
//        return "posts/create";
//    }
//
//    // Creates new post, uploads file, and adds row to posts table
//    @PostMapping("/posts/create")
//    public String createPost(
//            @ModelAttribute @Valid Post post,
//            @RequestParam(name = "file") MultipartFile uploadedFile,
//            Errors validation,
//            Model model)
//    {
//        // Enforces post parameters of size and not being empty
//        if(validation.hasErrors()) {
//            model.addAttribute("errors", validation);
//            model.addAttribute("post", post);
//            return "posts/create";
//        }
//
//        // Sets the user of the post to be the logged in user, uploads the file in the form, then saves post into table
//        post.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        fileUploadService.uploadFile(uploadedFile, post, model);
//        postDao.save(post);
//
//        // Using emailService to send an email out of created post
//        emailService.prepareAndSend(post, "Post Created", "" +
//                "A new post has been successfully created" +
//                "New Post:" +
//                "\n\n" +
//                post.getTitle() +
//                "\n" +
//                post.getBody());
//        return "redirect:/posts";
//    }
//
//    // Shows form to edit a post
//    @GetMapping("/posts/{id}/edit")
//    public String showEditPostForm(@PathVariable Long id, Model model) {
//        // Setting post by id in URL path and passes it to template
//        Post post = postDao.getById(id);
//        model.addAttribute("post", post);
//        return "posts/edit";
//    }
//
//    // Takes changes to post and alters posts table
//    @PostMapping("/posts/{id}/edit")
//    public String editPost(@ModelAttribute @Valid Post post, Errors validation, Model model) {
//        // Enforces post parameters of size and not being empty
//        if(validation.hasErrors()) {
//            model.addAttribute("errors", validation);
//            model.addAttribute("post", post);
//            return "/posts/edit";
//        }
//
//        // Sets post user by who is logged in at the time
//        post.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        postDao.save(post);
//
//        // Using emailService to send email of edited post
//        emailService.prepareAndSend(post, "Post Edited", "" +
//                "Your post has been successfully edited." +
//                "\n" +
//                "New Post:" +
//                "\n\n" +
//                post.getTitle() +
//                "\n" +
//                post.getBody());
//        return ("redirect:/posts/" + post.getId());
//    }
//
//    // Shows form to delete a post
//    @GetMapping("/posts/{id}/delete")
//    public String showDeletePost(@PathVariable Long id, Model model) {
//        // Sets post by id in URL path, sends post to template
//        Post post = postDao.getById(id);
//        model.addAttribute("post", post);
//        return"/posts/delete";
//    }
//
//    // Removes post
//    @PostMapping("/posts/{id}/delete")
//    public String deletePost(@ModelAttribute Post post) {
//        postDao.delete(post);
//        return("redirect:/profile/");
//    }
//
//    // Views all posts in JSON format
//    @GetMapping("/posts.json")
//    public @ResponseBody List<Post> viewAllPostsInJSONFormat() {
//        // Creating posts list and returning
//        List<Post> posts = postDao.findAll();
//        return posts;
//    }
//
//    // Views all posts with Ajax
//    @GetMapping("/posts/ajax")
//    public String viewAllPostsWithAjax() {
//        return "posts/ajax";
//    }
}
