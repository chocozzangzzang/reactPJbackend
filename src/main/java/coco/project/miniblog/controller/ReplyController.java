package coco.project.miniblog.controller;

import coco.project.miniblog.dto.ReplyDTO;
import coco.project.miniblog.entity.Reply;
import coco.project.miniblog.service.ReplyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reply/*")
@CrossOrigin(origins="http://localhost:3000")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @PostMapping("write")
    public Reply writeReply(@RequestBody ReplyDTO replyDTO) {
        return replyService.writeReply(replyDTO);
    }

    @DeleteMapping("delete/{rid}")
    public void deleteReply(@PathVariable Long rid) {
        replyService.deleteReply(rid);
    }

    @PutMapping("edit")
    public Reply editReply(@RequestBody ReplyDTO replyDTO) {
//        System.out.println(replyDTO.getReplyId() + " " + replyDTO.getReplyContent() + " " + replyDTO.getPostId());
        return replyService.editReply(replyDTO);
    }
}
