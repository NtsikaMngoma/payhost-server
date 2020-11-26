package za.co.payhost.server.api.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import za.co.payhost.server.api.domain.models.PaymentTransactions;
import za.co.payhost.server.api.service.dto.PaymentTransactionsDTO;

/**
 *
 * Mapper for the entity {@link PaymentTransactions} and its DTO {@link PaymentTransactionsDTO}
 * */
@Mapper(componentModel = "spring")
public interface PaymentTransactionsMapper extends EntityMapper<PaymentTransactionsDTO, PaymentTransactions>{
    @Mapping(source = "id", target = "id")
    PaymentTransactionsDTO toDto(PaymentTransactions transactions);

    default PaymentTransactions fromId(Long id) {
        if (id == null)
            return null;
        PaymentTransactions paymentTransaction = new PaymentTransactions();
        paymentTransaction.setId(id);
        return paymentTransaction;
    }
}
