package by.arsy.controller.logApplicationController;

import by.arsy.p2dto.ChangePasswordDto;
import by.arsy.p2entity.User;
import by.arsy.p4service.UserService;
import by.arsy.p7coder.HashCoder;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@Validated
@EnableWebMvc
@RequestMapping("/change_pass")
public class PasswordChangerController extends HttpServlet {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String changePasswordPage(Model model) {
        model.addAttribute("changePasswordDto", new ChangePasswordDto());
        return "log/change_password";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String changePassword(@ModelAttribute @Valid ChangePasswordDto changePasswordDto,
                                 BindingResult bindingResult,
                                 HttpSession session,
                                 Model model) {

        model.addAttribute("changePasswordDto", new ChangePasswordDto());
        if (bindingResult.hasErrors()) {
            model.addAttribute("saveOldPass", changePasswordDto.getOldPass());
            model.addAttribute("saveNewPass", changePasswordDto.getNewPass());
            model.addAttribute("saveRepeatPass", changePasswordDto.getRepeatPass());
            model.addAttribute("answer_change", "there should be no empty lines");
            return "log/change_password";
        }

        User user = (User) session.getAttribute("user");

        if (service.getUser(user.getName(), changePasswordDto.getOldPass()).isPresent()) {
            if (changePasswordDto.getNewPass().equals(changePasswordDto.getRepeatPass())) {
                service.changePass(user.getName(), HashCoder.getHash(changePasswordDto.getNewPass()));
                model.addAttribute("good_answer");
                model.addAttribute("answer_change", "change is OK");
            } else {
                model.addAttribute("saveOldPass", changePasswordDto.getOldPass());
                model.addAttribute("answer_change", "wrong repeat password");
            }
        } else {
            model.addAttribute("answer_change", "wrong password");
        }
        return "log/change_password";
    }

}
