package ms.custumer.services;

import ms.custumer.dto.CustumerRequest;
import ms.custumer.dto.CustumerResponse;
import ms.custumer.mappers.CustumerMapper;
import ms.custumer.models.Custumer;
import ms.custumer.repositories.CustumerRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustumerServiceImpl implements CustumerService {
    private CustumerRepository custumerRepository;
    private CustumerMapper custumerMapper;

    public CustumerServiceImpl(CustumerMapper custumerMapper, CustumerRepository custumerRepository){
        this.custumerRepository = custumerRepository;
        this.custumerMapper = custumerMapper;
    }

    @Override
    public CustumerResponse save(CustumerRequest custumerRequest) {
        Custumer custumer = custumerMapper.toEntity(custumerRequest);
        Custumer custumerSaved = custumerRepository.save(custumer);
        return custumerMapper.fromEntity(custumerSaved);
    }

    @Override
    public List<CustumerResponse> getCustumers() {
        List<CustumerResponse> custumers = custumerRepository.findAll().stream().map(custumer -> custumerMapper.fromEntity(custumer)).collect(Collectors.toList());
        return custumers;
    }

    @Override
    public CustumerResponse getCustumer(Long id) {
        Custumer custumer = custumerRepository.findById(id).get();
        return custumerMapper.fromEntity(custumer);
    }

    @Override
    public CustumerResponse updateCustumer(CustumerRequest custumerRequest) {
        Custumer custumer = custumerMapper.toEntity(custumerRequest);
        Custumer custumerUpdated = custumerRepository.saveAndFlush(custumer);
        return custumerMapper.fromEntity(custumerUpdated);
    }

    @Override
    public void deleteCustumer(Long id) {
        custumerRepository.deleteById(id);
    }
}
