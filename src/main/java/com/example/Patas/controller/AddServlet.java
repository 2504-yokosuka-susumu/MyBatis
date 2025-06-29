package com.example.Patas.controller;

import com.example.Patas.controller.form.TaskForm;
import com.example.Patas.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddServlet {
    @Autowired
    AddService addService;
    @Autowired
    public SmartValidator validator;

    /*
     * タスク追加画面表示
     */
    @GetMapping("/new")
    public ModelAndView newContent() {
        ModelAndView mav = new ModelAndView();
        // form用の空のentityを準備
        TaskForm taskForm = new TaskForm();
        // 画面遷移先を指定
        mav.setViewName("/new");
        // 準備した空のFormを保管
        mav.addObject("formModel", taskForm);
        return mav;
    }

    /*
     * タスク追加処理
     */
    @PostMapping("/add")
    public ModelAndView addContent(@ModelAttribute("formModel") TaskForm taskForm,
                                   BindingResult result, ModelAndView mav) {
        TaskForm replaceTaskForm = taskForm;
        String replaceContent = replaceTaskForm.getContent();
        replaceContent = replaceContent.replaceFirst("^[\\s　]+", "").replaceFirst("[\\s　]+$", "");
        replaceContent = replaceContent.replaceAll("\\r\\n|\\r|\\n", "");
        replaceTaskForm.setContent(replaceContent);

        validator.validate(replaceTaskForm, result);

        if(result.hasErrors()) {
            // 画面遷移先を指定
            mav.setViewName("/new");
            return mav;
        } else {
            // 投稿をテーブルに格納
            addService.saveTask(taskForm);
            // rootへリダイレクト
            return new ModelAndView("redirect:/");
        }
    }
}
