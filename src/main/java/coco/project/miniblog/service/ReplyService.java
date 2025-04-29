package coco.project.miniblog.service;

import coco.project.miniblog.dto.ReplyDTO;
import coco.project.miniblog.entity.Reply;

public interface ReplyService {

    public Reply writeReply(ReplyDTO replyDTO);

    public void deleteReply(Long rid);

    public Reply editReply(ReplyDTO replyDTO);
}
