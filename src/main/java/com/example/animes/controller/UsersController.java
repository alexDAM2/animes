package com.example.animes.controller;


import com.example.animes.domain.dto.ErrorMessage;
import com.example.animes.domain.model.Favorite;
import com.example.animes.domain.dto.ResponseList;
import com.example.animes.domain.dto.UserRegisterRequest;
import com.example.animes.domain.model.Users;
import com.example.animes.repository.FavoriteRepository;
import com.example.animes.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired private UsersRepository usersRepository;
    @Autowired private FavoriteRepository favoriteRepository;
    @Autowired private BCryptPasswordEncoder passwordEncoder;

    @PostMapping(path = "/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest userRegisterRequest){

        if (usersRepository.findByUsername(userRegisterRequest.username) == null) {
            Users user = new Users();
            user.username = userRegisterRequest.username;
            user.password = passwordEncoder.encode((CharSequence) userRegisterRequest.password);
            user.enabled = true;
            return ResponseEntity.ok().body(usersRepository.save(user).userid.toString());
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorMessage.message("User could not be registered"));
    }

    @GetMapping
    public ResponseEntity<?> getALI(){
        return ResponseEntity.ok().body(ResponseList.list(usersRepository.findBy()));
    }

    @PostMapping("/{id}/favorites")
    public ResponseEntity<?> addFavorite(@RequestBody Favorite favorite, Authentication authentication) {
        if (usersRepository.findByUsername((authentication.getName())).userid.equals(favorite.userid)){
            favoriteRepository.save(favorite);
            return ResponseEntity.ok().build();
        } else {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ErrorMessage.message("No authorized"));
        }
    }
}
