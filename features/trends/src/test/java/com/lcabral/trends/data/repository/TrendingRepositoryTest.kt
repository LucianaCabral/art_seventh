package com.lcabral.trends.data.repository

import com.lcabral.trends.data.source.TrendingDataSourceImpl
import com.lcabral.trends.domain.model.Trending
import com.lcabral.trends.domain.repository.TrendingsRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

internal class TrendingRepositoryTest {

    private val mockList: List<Trending> =listOf(mockk(relaxed = true), mockk(relaxed = true))
    private val trendingsDataSource: TrendingDataSourceImpl = mockk(relaxed = true)
    private val subject: TrendingsRepository = TrendingRepositoryImpl(trendingsDataSource)

    @Test
    fun `getTrendings Should return Trendings`() {
        // Given
        every { trendingsDataSource.getTrending() } returns flow { emit(mockList) }

        // When
        subject.getTrendings()

        // Then
       coVerify { trendingsDataSource.getTrending() }
    }

    @Test
    fun `when the api doesnt return anything then get values form database`() = runBlocking {
        // Given
        coEvery { subject.getTrendings()} returns emptyFlow()

        // When
       trendingsDataSource.getTrending()

        // Then
        coVerify(exactly = 1) { subject.getTrendings() }
    }
}
