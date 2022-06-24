package com.example.faq.controller;

import com.example.faq.Service.FaqService;
import com.example.faq.model.Faq;
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

    @GetMapping("/faqs")
    public ResponseEntity<List<Faq>> faqList(@RequestParam Faq faq){
        List<Faq> faqs = faqService.findAll();

        try{
            if(faqs.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(faqs,HttpStatus.OK);
            } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }

        @PostMapping("/faqs/write")
    public ResponseEntity<Faq> registerFaq(@RequestBody Faq faq){

        boolean bSuccess = faqService.save(faq);

            try {
                if(bSuccess == true) {
                    return new ResponseEntity<>(faq, HttpStatus.CREATED);
                }
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    @PutMapping("/faqs/write/{no}")
    public ResponseEntity<Faq> updateFaq(@PathVariable("no") Long no,
                                         @RequestBody Faq faq){
        boolean bSuccess = faqService.save(faq);
        try {
            if(bSuccess == true) {
                return new ResponseEntity<>(faq, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/faqs/deletion/{no}")
    public ResponseEntity<HttpStatus> deleteFaq(@PathVariable("no") Long no){
        boolean bSuccess = faqService.deleteFaq(no);


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
