package com.groupeisi.m2gl.mohamed_zayad.example.Controller;
import com.groupeisi.m2gl.mohamed_zayad.example.Controller.*;
import com.groupeisi.m2gl.mohamed_zayad.example.model.PalindromeRequest;
import com.groupeisi.m2gl.mohamed_zayad.example.model.PalindromeResponse;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



class PalindromeControllerTest {
        private PalindromeController palindromeController;

        @BeforeEach
        public void setup() {
            palindromeController = new PalindromeController();
        }

        @Test
        public void testPalindromeWord() {
            // Préparation
            PalindromeRequest request = new PalindromeRequest();
            request.setMotAverifier("kayak");

            // Exécution
            ResponseEntity<PalindromeResponse> responseEntity = palindromeController.checkPalindrome(request);

            // Vérification
            assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
            assertEquals(true, responseEntity.getBody().isPalindrome());
        }

        @Test
        public void testNonPalindromeWord() {
            // Préparation
            PalindromeRequest request = new PalindromeRequest();
            request.setMotAverifier("hello");

            // Exécution
            ResponseEntity<PalindromeResponse> responseEntity = palindromeController.checkPalindrome(request);

            // Vérification
            assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
            assertEquals(false, responseEntity.getBody().isPalindrome());
        }



}