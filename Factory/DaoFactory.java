package Factory;

import com.trip.dao.AdminDao;
import com.trip.dao.AlbumDao;
import com.trip.dao.AttentionDao;
import com.trip.dao.CircleDao;
import com.trip.dao.CityDao;
import com.trip.dao.CommentDao;
import com.trip.dao.FoodDao;
import com.trip.dao.FriendDao;
import com.trip.dao.ImagesDao;
import com.trip.dao.OrderDao;
import com.trip.dao.PlaceDao;
import com.trip.dao.PlanDao;
import com.trip.dao.PraiseDao;
import com.trip.dao.TrackDao;
import com.trip.dao.UserDao;
import com.trip.impl.AblumImpl;
import com.trip.impl.AdminImpl;
import com.trip.impl.AttentionImpl;
import com.trip.impl.CircleImpl;
import com.trip.impl.CityImpl;
import com.trip.impl.CommentImpl;
import com.trip.impl.FoodImpl;
import com.trip.impl.FriendImpl;
import com.trip.impl.ImagesImpl;
import com.trip.impl.OrderImpl;
import com.trip.impl.PlaceImpl;
import com.trip.impl.PlanImpl;
import com.trip.impl.PraiseImpl;
import com.trip.impl.TrackImpl;
import com.trip.impl.UserImpl;

public final class DaoFactory {
     public static UserDao getUserDaoInstance(){
		return new UserImpl();
    }
     public static  AlbumDao getAblumDaoInstance(){
 		return new AblumImpl();
     }
     public static AdminDao getAdminDaoInstance(){
    	 return new AdminImpl();
     }
     public static AttentionDao getAttentionDaoIntance(){
    	 return new AttentionImpl(); 
     }
     public static CircleDao getCircleDaoInstance(){
    	 return new CircleImpl();
     }
     public static CommentDao getCommentDaoInstance(){
    	 return new CommentImpl();
     }
     public static FriendDao getFriendDaoInstance(){
    	 return new FriendImpl();
     }
     public static PlaceDao getPlaceDaoInstance(){
    	 return new PlaceImpl();
     }
     public static PlanDao getPlanDaoInstance(){
    	 return new PlanImpl();
     }
     public static PraiseDao getPraiseDaoInstance(){
    	 return new PraiseImpl();
     }
     public static TrackDao getTrackDaoInstance(){
    	 return new TrackImpl();
     }
     public static OrderDao getOrderDaoInstance(){
    	 return new OrderImpl();
     }
     public static CityDao getCityDaoInstance(){
    	 return new CityImpl();
     }
     public static FoodDao getFoodDaoInstance(){
    	 return new FoodImpl();
     }
     public static ImagesDao getImagesDaoInstance(){
    	 return new ImagesImpl();
     }
}
