package com.eurekanetwork.wallet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.eurekanetwork.wallet.model.contract.Contract;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragment;
import com.eurekanetwork.wallet.ui.fragment.my_contracts_fragment.ContractItemListener;
import com.eurekanetwork.wallet.ui.fragment.my_contracts_fragment.MyContractsInteractor;
import com.eurekanetwork.wallet.ui.fragment.my_contracts_fragment.MyContractsPresenterImpl;
import com.eurekanetwork.wallet.ui.fragment.my_contracts_fragment.MyContractsView;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class MyContractsPresenterTest {

    @Mock
    private MyContractsView view;
    @Mock
    private MyContractsInteractor interactor;
    private MyContractsPresenterImpl presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        presenter = new MyContractsPresenterImpl(view, interactor);
    }

    @Test
    public void initialize_EmptyContracts() {
        when(interactor.getContracts())
                .thenReturn(Collections.<Contract>emptyList());

        presenter.initializeViews();

        verify(view, times(1)).setPlaceHolder();
        verify(view, never()).setAlertDialog(anyInt(), anyInt(), (BaseFragment.PopUpType) any());
    }

    @Test
    public void initialize_NullContractsError() {
        when(interactor.getContracts())
                .thenReturn(null);

        presenter.initializeViews();

        verify(view, times(1)).setAlertDialog(anyInt(), anyInt(), (BaseFragment.PopUpType) any());

        verify(view, never()).setUpRecyclerView(anyList(), (ContractItemListener) any());
        verify(view, never()).setPlaceHolder();
    }

    @Test
    public void initialize_Success() {
        when(interactor.getContracts())
                .thenReturn(Arrays.asList(new Contract(), new Contract()));

        presenter.initializeViews();

        verify(view, times(1)).setUpRecyclerView(anyList(), (ContractItemListener) any());

        verify(view, never()).setAlertDialog(anyInt(), anyInt(), (BaseFragment.PopUpType) any());
        verify(view, never()).setPlaceHolder();

    }


}
