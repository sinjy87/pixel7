package spring.sts.pixel7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.model.auction.Auction_successDAO;
@Controller
public class Auction_successController {
  @Autowired
  private Auction_successDAO dao;
 
}
