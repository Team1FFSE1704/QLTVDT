package snippet;

public class Snippet {
	//l?y danh sách t?nh thành
	public ArrayList<TinhThanh> getDSTinh() {
		ArrayList<TinhThanh> dsTinhThanh = new ArrayList<TinhThanh>();
	
		try {
			String queryString = "SELECT * FROM tinh_thanhpho";
			PreparedStatement statement = conn.prepareStatement(queryString);
	
			ResultSet result = statement.executeQuery();
	
			while (result.next()) {
				
				int maTinh = result.getInt("matinh");
				String tenTinh = result.getString("tentinh");
				
	
				dsTinhThanh.add(new TinhThanh(maTinh,tenTinh));
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return dsTinhThanh;
	}
}

