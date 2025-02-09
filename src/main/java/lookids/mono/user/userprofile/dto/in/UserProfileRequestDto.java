package lookids.mono.user.userprofile.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookids.mono.user.userprofile.domain.UserProfile;
import lookids.mono.user.userprofile.vo.in.UserProfileRequestVo;

@Getter
@NoArgsConstructor
public class UserProfileRequestDto {

	private String userUuid;
	private String nickname;

	@Builder
	public UserProfileRequestDto(String userUuid, String nickname) {
		this.userUuid = userUuid;
		this.nickname = nickname;
	}

	public static UserProfileRequestDto toDto(UserProfileRequestVo userProfileRequestVo) {
		return UserProfileRequestDto.builder()
			.userUuid(userProfileRequestVo.getUuid())
			.nickname(userProfileRequestVo.getNickname())
			.build();
	}

	public static UserProfileRequestDto toDtoString(String uuid, String nickname) {
		return UserProfileRequestDto.builder().userUuid(uuid).nickname(nickname).build();
	}

	public UserProfile toEntity(String tag, String image) {
		return UserProfile.builder()
			.userUuid(userUuid)
			.nickname(nickname)
			.tag(tag)
			.tierCode("welcome")
			.image(image)
			.build();
	}
}
