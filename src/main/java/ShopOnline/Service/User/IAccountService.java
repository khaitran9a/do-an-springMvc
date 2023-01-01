package ShopOnline.Service.User;

import org.springframework.stereotype.Service;

import ShopOnline.Entity.Users;

@Service
public interface IAccountService {
	public int AddAccount(Users user);
	public Users CheckAccount(Users user);
	public boolean CheckUserName(Users user);
	
}
