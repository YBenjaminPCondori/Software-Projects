export const layerDataCode = `std::vector<std::vector<int>> INNER(
  nInner * nFeatures,
  std::vector<int>(nInnerPoints, 0)
);

std::vector<std::vector<int>> OUTER(
  nInner,
  std::vector<int>(nOuterPoints, 0)
);`

export const computeReduceCode = `int Compute(int diff, int delta_shift, const std::vector<int>& row, int& offset, int& index) {
  index = diff >> delta_shift;
  offset = diff & ((1 << delta_shift) - 1);
  long long Q = row[index + 1] - row[index];
  Q *= offset;
  Q >>= delta_shift;
  Q += row[index];
  return (int)Q;
}

int ReduceVector(const std::vector<int>& V, int mult, int denom, int min, int max) {
  long long x = 0;
  for (short i = 0; i < (short)V.size(); ++i) {
    x += V[i];
  }
  x *= mult;
  x >>= denom;
  if (x <= min) x = min + 1;
  if (x >= max) x = max - 1;
  return (int)x;
}`

export const inferenceCode = `//1 FPGA cycle
for (int k = 0; k < nInner; ++k) {
  for (int j = 0; j < nFeatures; ++j) {
    int m = k * nFeatures + j;
    intermediate_matrix[k][j] = Compute(
      features[j] - FeatureMin,
      nInnerShift,
      INNER[m],
      innerOffset[m],
      innerIndex[m]
    );
  }
}

//1 FPGA cycle
for (int k = 0; k < nInner; ++k) {
  intermediate_vector[k] = ReduceVector(
    intermediate_matrix[k],
    MultInner,
    DenomInner,
    TargetMin,
    TargetMax
  );
}

//1 FPGA cycle
for (int j = 0; j < nInner; ++j) {
  outer_vector[j] = Compute(
    intermediate_vector[j] - TargetMin,
    nOuterShift,
    OUTER[j],
    outerOffset[j],
    outerIndex[j]
  );
}

//1 FPGA cycle
predicted = ReduceVector(
  outer_vector,
  MultOuter,
  DenomOuter,
  TargetMin,
  TargetMax
);`
