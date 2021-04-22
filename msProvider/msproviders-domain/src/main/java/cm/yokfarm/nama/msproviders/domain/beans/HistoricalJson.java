package cm.yokfarm.nama.msproviders.domain.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.util.Date;

/**
 * Historical Json Data for Providers has Products Entity
 *
 * @author Meudje
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricalJson implements Serializable {
    private boolean inStock;

    @Min(1)
    private Long price;

    @PastOrPresent
    private Date verificationDate;
}