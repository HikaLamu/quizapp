package com.obsa.quizapp.controller;

import com.obsa.quizapp.entity.Question;
import com.obsa.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>>  getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("writeQuestion")
    public ResponseEntity<String>  createQuestion(@RequestBody Question question){

        return questionService.createQuestion(question);
    }

    @DeleteMapping("delete/{Id}")

    public String deleteQuestionById(@PathVariable Integer Id){
        return questionService.deleteQuestionById(Id);
    }

//    @PutMapping ("update")
//    public List<Question> updateQuestion(@RequestBody Question question){
//        return questionService.updateQuestion(question);
//    }

}

