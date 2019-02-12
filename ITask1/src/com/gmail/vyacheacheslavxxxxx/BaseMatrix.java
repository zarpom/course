package com.gmail.vyacheacheslavxxxxx;
 

public abstract class BaseMatrix {
    public BaseMatrix() {
    }
    
    abstract BaseMatrix getInstanse(int row, int column);

    public abstract void setEl(int x, int y, double value);

    public abstract double getEl(int x, int y);

    public abstract int getRow();

    public abstract void setRow(int paramInt);

    public abstract int getColumn();

    public abstract void setColumn(int paramInt);

    public double determinant(BaseMatrix matrix) {
        double result = 0.0D;
        if (matrix.getRow() == 1) {
            return matrix.getEl(0, 0);
        }
        if (matrix.getRow() == 2) {
            return matrix.getEl(0, 0) * matrix.getEl(1, 1) - matrix.getEl(0, 1) * matrix.getEl(1, 0);
        }
        for (int i = 0; i < matrix.getColumn(); i++) {
            BaseMatrix tempMatric = getInstanse(matrix.getRow() - 1, matrix.getColumn() + 1);
            for (int j = 1; j < matrix.getRow(); j++) {
                for (int k = 0; k < matrix.getRow(); k++) {
                    if (k < i) {
                        tempMatric.setEl(j - 1, k, matrix.getEl(j, k));
                    } else if (k > i) {
                        tempMatric.setEl(j - 1, k - 1, matrix.getEl(j, k));
                    }
                }
            }
            result += matrix.getEl(0, i) * Math.pow(-1.0D, i) * determinant(tempMatric);
        }
        return result;
    }

    public BaseMatrix invert(BaseMatrix sourceMatrix) {
        BaseMatrix matrix = dublicate(sourceMatrix);
        int n = matrix.getRow();
        BaseMatrix x = getInstanse(n, n);
        BaseMatrix b = getInstanse(n, n);
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            b.setEl(i, i, 1.0D);
        }
        matrix = gaussian(matrix, index);

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = 0; k < n; k++)
                    b.setEl(index[j], k, b.getEl(index[j], k) - matrix.getEl(index[j], i) * b.getEl(index[i], k));
        for (int i = 0; i < n; i++) {
            x.setEl(n - 1, i, b.getEl(index[(n - 1)], i) / matrix.getEl(index[(n - 1)], n - 1));
            for (int j = n - 2; j >= 0; j--) {
                x.setEl(j, i, b.getEl(index[j], i));
                for (int k = j + 1; k < n; k++) {
                    x.setEl(j, i, x.getEl(j, i) - matrix.getEl(index[j], k) * x.getEl(k, i));
                }
                x.setEl(j, i, x.getEl(j, i) / matrix.getEl(index[j], j));
            }
        }
        return x;
    }

    public static BaseMatrix gaussian(BaseMatrix matrix, int[] index) {
        int n = matrix.getRow();
        double[] c = new double[n];
        for (int i = 0; i < n; i++)
            index[i] = i;
        for (int i = 0; i < n; i++) {
            double c1 = 0.0D;
            for (int j = 0; j < n; j++) {
                double c0 = Math.abs(matrix.getEl(i, j));
                if (c0 > c1)
                    c1 = c0;
            }
            c[i] = c1;
        }
        int k = 0;
        for (int j = 0; j < n - 1; j++) {
            double pi1 = 0.0D;
            for (int i = j; i < n; i++) {
                double pi0 = Math.abs(matrix.getEl(index[i], j));

                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; i++) {
                double pj = matrix.getEl(index[i], j) / matrix.getEl(index[j], j);
                matrix.setEl(index[i], j, pj);
                for (int l = j + 1; l < n; l++)
                    matrix.setEl(index[i], l, matrix.getEl(index[i], l) - pj * matrix.getEl(index[j], l));
            }
        }
        return matrix;
    }

    public BaseMatrix multiplyByMatrix(BaseMatrix m1, BaseMatrix m2) throws java.lang.Exception {
        if (m1.getColumn() != m2.getRow())
            throw new Exception("row and column doesnt equal");
        BaseMatrix resultMatrix = getInstanse(m1.getRow(), m2.getColumn());
        for (int i = 0; i < m1.getRow(); i++) {
            for (int j = 0; j < m2.getColumn(); j++) {
                for (int k = 0; k < m1.getColumn(); k++) {
                    resultMatrix.setEl(i, j, resultMatrix.getEl(i, j) + (m1.getEl(i, k) * m2.getEl(k, j)));
                }
            }
        }
        return resultMatrix;
    }

    private BaseMatrix dublicate(BaseMatrix baseMatrix) {
        BaseMatrix copy = getInstanse(baseMatrix.getRow(), baseMatrix.getColumn());
        for (int i = 0; i < baseMatrix.getRow(); i++) {
            for (int j = 0; j < baseMatrix.getColumn(); j++) {
                copy.setEl(i, j, baseMatrix.getEl(i, j));
            }
        }
        return copy;

    }
}