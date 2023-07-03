package com.lcabral.features.upcoming.domain

import com.lcabral.features.upcoming.domain.model.Upcoming
import com.lcabral.features.upcoming.domain.repository.UpcomingRepository
import com.lcabral.features.upcoming.domain.usecase.GetUpcomingUseCase
import io.mockk.Called
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import org.junit.Test

internal class GetUpcomingUseCaseTest {
    private val upcomingRepository: UpcomingRepository = mockk(relaxed = true)
    private val subject = GetUpcomingUseCase(upcomingRepository)

    @Test
    fun `getTrendings Should return trendings movies`() {
        // Given
        val result: List<Upcoming> = listOf(
            mockk(relaxed = true),
            mockk(relaxed = true),
            mockk(relaxed = true)
        )

        every { upcomingRepository.getUpcoming() } returns flow { emit(result) }

        // When
        subject.invoke()

        // Then
        verify { upcomingRepository.getUpcoming() }
    }

    @Test
    fun `getTrendings not  Should return trendings movies`() {
        // Given
        every { upcomingRepository.getUpcoming() } returns flow { emit(emptyList()) }

        // When
        subject.invoke()

        // Then
        verify { upcomingRepository.getUpcoming().wasNot(Called) }
    }
}
