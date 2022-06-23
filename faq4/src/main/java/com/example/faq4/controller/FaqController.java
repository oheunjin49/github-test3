package com.example.faq4.controller;


import com.example.faq4.model.Faq;
import com.example.faq4.service.FaqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FaqController {

    @Autowired
    private FaqService faqService;

    Logger logger = LoggerFactory.getLogger(this.getClass());


   @GetMapping("/faqs")
    public ResponseEntity<List<Faq>> faqList(@RequestParam Faq faq){
       List<Faq> faqs = faqService.findAll();

       try {


           if (faqs.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }

           return new ResponseEntity<>(faqs, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }

   @GetMapping("/faqs/write")
   public ResponseEntity<Faq> registerFaq(@RequestParam Faq faq){
       logger.info("tutorial {}", faq);
       boolean bSuccess = faqService.save(faq);
       logger.info("bSuccess {}", bSuccess);
       try {
//			boolean bSuccess = tutorialService.save(tutorial);
           if(bSuccess == true) {
               return new ResponseEntity<>(faq, HttpStatus.CREATED);
           }
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);

       } catch (Exception e) {
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }
    @GetMapping("/faqs/write/{no}")
    public ResponseEntity<Faq> updateFaq(@RequestParam Faq faq){
        logger.info("tutorial {}", faq);
        boolean bSuccess = faqService.save(faq);
        logger.info("bSuccess {}", bSuccess);
        try {
//			boolean bSuccess = tutorialService.save(tutorial);
            if(bSuccess == true) {
                return new ResponseEntity<>(faq, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/faqs/deletion/{no}")
    public ResponseEntity<HttpStatus> deleteFaq(@PathVariable("no") int no){
        boolean bSuccess = faqService.deleteFaq(no);

        logger.info("bSuccess {}", bSuccess);

        try {
//			boolean bSuccess = tutorialService.deleteById(id);

            if(bSuccess == true) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
