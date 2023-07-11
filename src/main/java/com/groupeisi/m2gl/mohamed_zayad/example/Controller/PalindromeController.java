package com.groupeisi.m2gl.mohamed_zayad.example.Controller;

import com.groupeisi.m2gl.mohamed_zayad.example.model.PalindromeRequest;
import com.groupeisi.m2gl.mohamed_zayad.example.model.PalindromeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PalindromeController {

    @PostMapping("/checkpalindrome")
    public ResponseEntity<PalindromeResponse> checkPalindrome(@RequestBody PalindromeRequest request) {
        String motAverifier = request.getMotAverifier();
        boolean isPalindrome = isPalindrome(motAverifier);

        PalindromeResponse response = new PalindromeResponse(isPalindrome);
        HttpStatus status = isPalindrome ? HttpStatus.ACCEPTED : HttpStatus.OK;

        return new ResponseEntity<>(response, status);
    }

    private boolean isPalindrome(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
