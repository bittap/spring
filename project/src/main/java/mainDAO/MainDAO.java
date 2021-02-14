package mainDAO;

import java.util.List;

import mainDTO.MainDTO;


public interface MainDAO {
	public int today_price();
	public int today_order_count();
	
	public int before_price( );
	public int before_order_count();
	
	public List<MainDTO> month_order_list();
	
	public List<MainDTO> month_member_list();
}
