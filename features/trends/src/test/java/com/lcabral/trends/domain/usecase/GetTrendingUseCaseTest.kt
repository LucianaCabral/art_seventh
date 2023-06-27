package com.lcabral.trends.domain.usecase

import com.lcabral.trends.domain.model.Trending
import com.lcabral.trends.domain.repository.TrendingsRepository
import io.mockk.Called
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import org.junit.Test

internal class GetTrendingUseCaseTest {
    private val getTrendingsRepositoryTest: TrendingsRepository = mockk(relaxed = true)
    private val subject = GetTrendingUseCase(getTrendingsRepositoryTest)

    @Test
    fun `getTrendings Should return trendings movies`() {
        // Given
        val result: List<Trending> = listOf(
            mockk(relaxed = true),
            mockk(relaxed = true),
            mockk(relaxed = true))

        every { getTrendingsRepositoryTest.getTrendings() } returns flow { result }

        // When
        subject.invoke()

        // Then
        verify { getTrendingsRepositoryTest.getTrendings() }
    }

    @Test
    fun `getTrendings not  Should return trendings movies`() {
        // Given
        every { getTrendingsRepositoryTest.getTrendings() } returns flow { null }

        // When
        subject.invoke()

        // Then
        verify { getTrendingsRepositoryTest.getTrendings().wasNot(Called) }
    }
}
