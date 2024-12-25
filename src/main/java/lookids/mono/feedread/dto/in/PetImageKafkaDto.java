package lookids.mono.feedread.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lookids.mono.feedread.domain.FeedRead;

@Getter
@ToString
@NoArgsConstructor
public class PetImageKafkaDto {

	private String petCode;
	private String image;

	@Builder
	public PetImageKafkaDto(String petCode, String image) {
		this.petCode = petCode;
		this.image = image;
	}

	public FeedRead toImageUpdate(FeedRead feedRead) {
		return FeedRead.builder()
			.id(feedRead.getId())
			.feedCode(feedRead.getFeedCode())
			.uuid(feedRead.getUuid())
			.nickname(feedRead.getNickname())
			.tag(feedRead.getTag())
			.image(image)
			.content(feedRead.getContent())
			.state(feedRead.isState())
			.petCode(feedRead.getPetCode())
			.tagList(feedRead.getTagList())
			.mediaUrlList(feedRead.getMediaUrlList())
			.createdAt(feedRead.getCreatedAt())
			.build();
	}
}
