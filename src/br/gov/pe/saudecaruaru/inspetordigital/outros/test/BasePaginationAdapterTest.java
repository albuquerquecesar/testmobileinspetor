package br.gov.pe.saudecaruaru.inspetordigital.outros.test;

import br.gov.pe.saudecaruaru.inspetordigital.adapter.BasePaginationAdapter;
import br.gov.pe.saudecaruaru.inspetordigital.dao.EstabelecimentoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Estabelecimento;
import android.test.AndroidTestCase;
import android.view.View;
import android.view.ViewGroup;

public class BasePaginationAdapterTest extends AndroidTestCase{

	private EstabelecimentoDAO estabelecimentoDAO;

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.estabelecimentoDAO=EstabelecimentoDAO.getInstance();
	}

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	
	public void testPaginationInDataBase(){
		BasePaginationAdapter<Estabelecimento> adapter=new BasePaginationAdapter<Estabelecimento>(this.estabelecimentoDAO) {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		System.out.println("tamamho : "+adapter.getCount());
		for(int i=0; i< adapter.getCount(); i++){
			System.out.println("Estabelecimento ===> "+adapter.getItem(i));
		}
	}
	
}
