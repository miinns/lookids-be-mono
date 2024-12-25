package lookids.mono.manager.information.vo.out;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookids.mono.manager.information.dto.out.InformationMediaDto;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformationResponseVo {

	private String title;
	private String content;
	private List<InformationMediaDto> mediaUrls;
	private LocalDateTime createdAt;

}
