package com.human.jeungsangdiary.mypage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.human.jeungsangdiary.mypage.domain.graphObj;

@Controller
public class MypageController {
    

    @GetMapping("/graph")
    public String graph() {

        return "mypage/graph";
    }

	@GetMapping("/restgraph")
	@ResponseBody
	public List<graphObj> restgraph(@RequestParam("num") String num) {
		
		System.out.println("입력값은: " + num);
		
		// 서비스와 디비에서 가져온 샘플 데이터
		List<graphObj> graphobj = new ArrayList<graphObj>(); // regdate, num 컬럼
		graphobj.add(new graphObj("내분비", 3));
		graphobj.add(new graphObj("구강", 15));
		graphobj.add(new graphObj("피부", 24));
		graphobj.add(new graphObj("순환기", 35));
		graphobj.add(new graphObj("소화기", 54));
		
        
		// List<graphObj> test = peoplesv.getListPepleAll();
		// List<graphObj> test2 = peoplemapper.selectList();
		
		return graphobj;
	}

}
