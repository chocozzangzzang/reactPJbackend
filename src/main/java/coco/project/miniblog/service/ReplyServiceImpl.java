package coco.project.miniblog.service;

import coco.project.miniblog.dto.ReplyDTO;
import coco.project.miniblog.entity.Reply;
import coco.project.miniblog.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{


    private final ReplyRepository replyRepository;

    public ReplyServiceImpl(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @Override
    public Reply writeReply(ReplyDTO replyDTO) {
        Reply reply = new Reply(replyDTO.getReplyContent(), replyDTO.getPostId());
        return replyRepository.save(reply);
    }

    @Override
    public void deleteReply(Long rid) {
        replyRepository.deleteById(rid);
    }

    @Override
    public Reply editReply(ReplyDTO replyDTO) {
        Reply reply = Reply.toEntity(replyDTO);
        return replyRepository.save(reply);
    }

}
