package ShopOnline.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminHomeController extends AdminBaseController {
	@RequestMapping(value = {"quan-tri/"})
	public ModelAndView Index() {
		_mvShare.setViewName("admin/index");
		return _mvShare;
	}
}
